import React from 'react'

const Pagination = ({postsPP , totalPosts , paginate}) => {

const pageNumbers =[]
    for(let i = 1 ; i <= Math.ceil(totalPosts/postsPP) ; i++)
        {
            pageNumbers.push(i)
        }


    return (
        <nav>
            <ul class = "pagination">
                {pageNumbers.map(number =>
                (
                    <li key = {number} className = 'page-item'>
                    <a onClick={() => paginate(number)} href='#' className= 'page-link'>
                        {number}
                    </a>
                    </li>
                ))}
            </ul>
        </nav>
    )
}

export default Pagination
