const posts =
[
{title: 'Post One' , body :"This is post one"},
{title: 'Post Two' , body :"This is Two one"}
]

function getPosts()
{
   // Mimicing the fectch from a server 1000ms = 1 second so we are delaying by a second
   setTimeout(()=>
   {
    //Input and looping through the collection of posts
    var output = '';
    posts.forEach((post , index) =>
    {
        output += `<li>${post.title}</li>`

    })
    //insert into the body
    document.body.innerHTML = output;
   }, 1000)

   
}

//make function take in a callback function
function createPosts(post , callback)
{
    setTimeout(() => 
    {
        posts.push(post)
        callback();
    }, 2000);
}




//Waits two seconds then shows all posts
//Had to wait to create the post before calling the callback 
createPosts({title: 'Post Three' , body: 'This is post three'} , getPosts)