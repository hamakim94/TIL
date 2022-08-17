import { USERS } from "./users";

export const POSTS = [
    {
        imageUrl : 'https://i.imgur.com/YcP0tik.jpeg',
        user: USERS[0].user,
        likes : 7840,
        caption :  'Wow this is Caption!!!!!!! ( ͡° ͜ʖ ͡°) Wow this is Caption!!!!!!! ( ͡° ͜ʖ ͡°) Wow this is Caption!!!!!!! ( ͡° ͜ʖ ͡°)',
        profile_picture : USERS[0].image,
        comments : [
            {
                user : 'theMig',
                comment : 'well to study react-native quite fun but hard ;;'
            },
            {
                user : 'theLEE',
                comment : 'Once I wake up I just want to play'
            }
        ],
    },
    {
        imageUrl : 'https://i.imgur.com/GCBVgXD.jpeg',
        user: USERS[1].user,
        likes : 840,
        caption :  'Wow this is type 2 ( ͡° ͜ʖ ͡°)',
        profile_picture : USERS[1].image,
        comments : [
        ],
    },
]