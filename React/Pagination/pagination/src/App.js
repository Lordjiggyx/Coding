import React , {useState , useEffect} from 'react';
import axios from "axios"
import './App.css';
import Posts from "../src/Components/Posts"
import Pagination from '../src/Components/Pagination';

const App = () =>
{
//Use state for the posts value and method for changing the posts 
const [posts, setPosts] = useState([])

//Loading values as we are fecthing from an api
const [loading , setLoading] = useState(false)

//current page and method for changing the current page 
const [currentPage , setCurentPage] = useState(1)

//Varaible for the amount of posts per page and a method to change this 
const [postsPP , setPostsPP] = useState(10)


//use Effect 
useEffect(()=>
{
    const fetchPosts = async () =>
    {
        setLoading(true)
        const res = await axios.get("https://jsonplaceholder.typicode.com/posts")
        setPosts(res.data)
        setLoading(false)
    }

    fetchPosts()
}, [])

console.log(posts)
console.log(posts[10])

//get current posts
const indexLastPost = currentPage * postsPP
const indexFisrtPost = indexLastPost - postsPP
const currentPosts = posts.slice(indexFisrtPost , indexLastPost)


//Change page

const paginate =(pageNumber)=>
{
  setCurentPage(pageNumber)
}


  return (
      <div className = "container mt-5">
        <h1 className = "text-primary mb-3">My Blog</h1>
        <Posts  posts = {currentPosts} loading ={loading}/>
        <Pagination
        postsPP={postsPP}
        totalPosts={posts.length}
        paginate ={paginate}
        
      />
     </div>

  )
}

export default App;
