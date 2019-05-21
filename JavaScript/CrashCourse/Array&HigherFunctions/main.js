//Create Arrays one called companies and one called ages

const companies = [
    {name: "Company One", category: "Finance", start: 1981, end: 2003},
    {name: "Company Two", category: "Retail", start: 1992, end: 2008},
    {name: "Company Three", category: "Auto", start: 1999, end: 2007},
    {name: "Company Four", category: "Retail", start: 1989, end: 2010},
    {name: "Company Five", category: "Technology", start: 2009, end: 2014},
    {name: "Company Six", category: "Finance", start: 1987, end: 2010},
    {name: "Company Seven", category: "Auto", start: 1986, end: 1996},
    {name: "Company Eight", category: "Technology", start: 2011, end: 2016},
    {name: "Company Nine", category: "Retail", start: 1981, end: 1989}
  ];
  
  const ages = [33, 12, 20, 16, 5, 54, 21, 44, 61, 13, 15, 45, 25, 64, 32];

  //forEach - elegant way to loop through data

  //normal for loop
  /*
  for(var i =0 ; i<companies.length; i++)
  {
    console.log(companies[i]);
  }
*/

/*
  //forEach 
  //similar to java 
  companies.forEach(function(Company)
  {
    console.log(Company)
  });
*/


  //Filter - Allows us to filter things out of the array

//Get 21 and older
 // let canDrinkAlcohol=[];

  //Normal filter
  /*
  for(var i = 0;  i<ages.length; i++)
  {
    if(ages[i] >=21)
    {
        canDrinkAlcohol.push(ages[i])
    }
  }
  */

  //define a variable and then let it equal ages.filter
  //it takes in a function and the function takes an element
  //returns an any element that fits the if condition
/*
const canDrink = ages.filter(function(age)
{
    if(age>=21)
    {
        return true;
    }
})
*/

//Can also be done using arrow notation
//const canDrink = ages.filter(age => age >= 21)


//Filter Out retail companies

//const retailComapnies = companies.filter(retailCompany => retailCompany.category == "Retail")

//Filter Companies from the 80's
//const company80s = companies.filter(company => company.start >=1980 && company.start <= 1990)

//Filter companies that lasted ten years or more

//const lasted10 = companies.filter(company => (company.end - company.start >=10))

//console.log(lasted10)

  //map - can create a new array from a current array

  //create array of compnay names
 // const companynames = companies.map(company => company.name )

   //create array of compnay names and start and end dates
   ///const companyNameStartEnd = companies.map(company => `${company.name}  ${company.start}  ${company.end}`)

  //console.log(companyNameStartEnd)

  //sort

  //Sort companies by start date
  //a and b used to compare values
  //? is a tenaery operator meaning if the first is greater return 1 which means true
  //: the colon represents else return -1 which means false
 // const sortedCompanies = companies.sort((a,b)=> (a.start >b.start ? 1 : -1) )


 //sort ages
 //ascending
 //const sortedAges = ages.sort((a,b) => a - b)
 //descending
 //const sortedAgesdesc = ages.sort((a,b) => b - a)

  //console.log(sortedAges)




  //reduce - 

  //add ages together
/*
var ageSum = 0;
  for(var i = 0; i <ages.length ; i++)
  {
     ageSum = ageSum + ages[i] 
  }
*/

//const ageSum = ages.reduce((total  , age)=> total + age)

//get total years for all companies

//const totalYears = companies.reduce((total, company ) => total + (company.end - company.start) , 0)
//console.log(totalYears)


//combine methods

const combined = ages
.map(age => age*2)
.filter(age=> age>=40)
.sort((a,b) => a-b)
.reduce((a,b) => a + b,0)

console.log(combined)