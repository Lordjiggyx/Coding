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
function createPosts(post) {//A promise takes two parameters resolve nad reject
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        posts.push(post);
  
        const error = false;
  
        if (!error) {
          resolve();
        } else {
          reject('Error: Something went wrong');
        }
      }, 2000);
    });
  }
//createPosts({title: 'Post Three' , body: 'This is post three'})
//WE CAN USE THE .THEN SYNTAX
//Waits until resolved then calls get post
//.then(getPosts)





//Async await - a way to handle responses like using 'synchronised' in java

async function init()
{
   await createPosts({title: 'Post Three' , body: 'This is post three'})

   getPosts();
}


init()



















//promise all takes in an array of promises

/*
const promise1 = Promise.resolve('Hello World')
const promise2 = 10;
const promise3 = new Promise ((resolve , reject) =>
setTimeout(resolve , 2000 , 'goodbye'));

Promise.all([promise1 , promise2 , promise3]).then(values=> console.log(values));
*/

