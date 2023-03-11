import React from 'react';


export default function Post(props){
const {post} = props

    return(
        <div>
            <h3>To: {post.recipient}</h3>
            <h4>Subject: {post.title} </h4>
            <p>{post.body}</p>
        </div>
    )
}