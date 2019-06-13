
//Global variables
//Document location
const url = './docs/pdf.pdf';

//Document
let pdfDoc = null;

//Page number;
let pageNum = 1;

//Page render state
//Once the page is rendered it will be false or if it is rendering it will be true
let pageIsRendering = false;

//Page Number if we are fething multiple pages
let pageNumIsRendering = null

//scale
const scale = 1;

//Dom elements - canvas
canvas = document.querySelector('#pdf-render')

//Canvas context
ctx = canvas.getContext('2d');



//Functions

//Render the page done with arrow funuctions

const renderPage = num =>
{
    //letting the program know that it is in the state of rendering
    pageIsRendering = true

    //Get page
    //returns a promise and a page
    pdfDoc.getPage(num).then(page =>
        {
           //Set the scale of the pdf
           const viewport = page.getViewport({scale})
           //set canvas height to viewport height
           //Then settting the canvas width to the viewport width
          canvas.height = viewport.height
          canvas.width = viewport.width;

          //This is the variable thta will take in the dimensions for rendering
          const renderCtx ={
              canvasContext:ctx,
              viewport
          }

          page.render(renderCtx).promise.then(()=>
          {
              //page should be done rendering
              pageIsRendering = false;

              //check if the page number is pending
              if(pageNumIsRendering != null)
              {

                  renderPage(pageNumIsRendering)
                  pageNumIsRendering = null;

              }
          })
          //output current page
          document.querySelector('#page-num').textContent = num
        })
}

//Check for pages rendering
const queueRenderPage = num =>
{
    //Chcek to see if the page is rendering 
    if(pageNumIsRendering)
    {
        //if it rendering we will set the page number to what page is rendered
        pageNumIsRendering = num
    }
    else
    {
        renderPage(num)
    }
}

//show previous page
const showprev = ()=>
{
    //check if the page number is less thenor equal to one
 if(pageNum <= 1)
 {
     //we can return any page before the first so we just return the first
     return
 }
 //else we just change the value of the page number and pass it into the function
 pageNum--
 queueRenderPage(pageNum)
}

//show next page
const shownext = ()=>
{
//We check if this page number is the last page by checking if it is the max number of pages
 if(pageNum > pdfDoc.numPages)
 {
     return
 }
 //else we just add 1 to the current page number and pass it into the function
 pageNum++
 queueRenderPage(pageNum)
}



//Get Document
pdfjsLib.getDocument(url).promise.then(pdfDoc_=>
    {
        //set global pdf to the pdf document we get back
        pdfDoc = pdfDoc_;
        console.log(pdfDoc)

        //This gets the number of pages from the pdf as pdf has a numPages varibale
        //and sets it to the element with the id of page-count
        document.querySelector('#page-count').textContent = pdfDoc.numPages;


        renderPage(pageNum)
    })
    .catch(err =>
        {
            //Display error

            //This will create a  div element in the html 
            const div = document.createElement('div')
            //Gives thr div a class name
            div.className ='error'
            //This adds text to the div element
            div.appendChild(document.createTextNode(err.message))
            //This grabs the body element and inserts this new div before the canvas element
            document.querySelector('body').insertBefore(div, canvas)
            //We removve the top bar by grabbing it and setting the display to none
            document.querySelector('.top-bar').style.display = 'none'
        })



//EVENT LISTENERS
document.querySelector('#prev-page').addEventListener('click', showprev)
document.querySelector('#next-page').addEventListener('click', shownext)