import pickle
import pandas as pd
from tensorflow import keras
import tensorflow as tf
from tensorflow.keras.callbacks import TensorBoard
import matplotlib.pyplot as plt

df_train = pd.read_pickle('token_train_data.pkl')
df_test = pd.read_pickle('token_test_data.pkl')

token_train_data, train_lable = df_train['tokens'], df_train['labels']
token_test_data, test_lable = df_test['tokens'], df_test['labels']
import functions as fc

max_len=40
final_train_data = fc.fasttext_vectorize(fc.pad_sequence(token_train_data), max_len=max_len)
final_test_data = fc.fasttext_vectorize(fc.pad_sequence(token_test_data), max_len=max_len)


######
embedding_dim = 200
filter_sizes = (3, 4, 5)
num_filters = 100
dropout = 0.5
hidden_dims = 10
batch_size = 50
num_epochs = 10
min_word_count = 1
context = 10
conv_blocks = []
sequence_length = 200

# input_shape = (sequence_length, embedding_dim) # input shape for
input_shape = (max_len, 300) # input shape for data, (max_length of sent, vect)

model_input = keras.layers.Input(shape=input_shape)
z = model_input
for sz in filter_sizes:
    conv = keras.layers.Conv1D(filters=num_filters,
                         kernel_size=sz,
                         padding="valid",
                         activation="relu",
                         strides=1)(z)
    conv = keras.layers.MaxPooling1D(pool_size=2)(conv)
    conv = keras.layers.Flatten()(conv)
    conv_blocks.append(conv)
z = keras.layers.Concatenate()(conv_blocks) if len(conv_blocks) > 1 else conv_blocks[0]
z = keras.layers.Dense(hidden_dims, activation="relu", kernel_regularizer=keras.regularizers.l2(0.003), bias_regularizer=keras.regularizers.l2(0.003))(z)
z = keras.layers.Dropout(dropout)(z)
model_output = keras.layers.Dense(1, activation="sigmoid")(z)
model = keras.Model(model_input, model_output)
model.compile(loss="binary_crossentropy", optimizer="adam", metrics=["accuracy"])

import os #폴더 생성
checkpoint_dir = './ckpt1'
if not os.path.exists(checkpoint_dir):
    os.makedirs(checkpoint_dir)
callbacks = [
    keras.callbacks.EarlyStopping(monitor='val_accuracy', patience=0),
    # This callback saves a SavedModel every 100 batches.
    # We include the training loss in the folder name.
    keras.callbacks.ModelCheckpoint(
        filepath=checkpoint_dir + '/ckpt-loss={loss:.3f}',
        save_freq=500)
]
history = model.fit(final_train_data, train_lable, epochs=10, callbacks=callbacks, batch_size = batch_size, validation_data=(final_test_data, test_lable))

#CNN 모델에 fit한 history, string: ('accuracy'or'loss'), name : 해당이름으로 차트title과 차트파일명이 됨
#result_file폴더에 결과 그래프 저장


plot_graphs(history, 'accuracy')
plot_graphs(history, 'loss')