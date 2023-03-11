import React, {useState, useEffect} from 'react';
import axios from 'axios';
import Post from '../components/Post';


export default function Home(){
const [posts, setPosts] = useState([]);
 const [loading, setLoading] = useState(false);
const [error, setError]= useState();

useEffect(() => {
    setLoading(true);
    const getPosts = async () => {
        let response = await axios.get('/api/posts');
        if (response.status === 200){
            setPosts(response.data);
            setError(false);
            return;
        }
        setError(response.error);
    };
    getPosts();
    setLoading(false);
})

    return (
        <div>
        <h2>Posts</h2>
            {loading? (
                <div> loading...</div>
            ) : error ? (
                <div>{error}</div>
            ) : (
                <div>
                    {posts.map((post) => (
                        <div key={post.id}>
                            <Post post={post} />
                        </div>
                    ))}
                </div>
            )



            }
        </div>
    )
}