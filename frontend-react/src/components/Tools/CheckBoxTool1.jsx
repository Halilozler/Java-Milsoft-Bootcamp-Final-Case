import React from 'react'

const CheckBoxTool1 = ({text}) => {
  return (
    <div class="checkbox-wrapper-12">
        <div class="cbx">
            <input id="cbx-12" type="checkbox"/>
            <label for="cbx-12"></label>
            <svg width="15" height="14" viewBox="0 0 15 14" fill="none">
            <path d="M2 8.36364L6.23077 12L13 2"></path>
            </svg>
        </div>
        
        <svg xmlns="http://www.w3.org/2000/svg" version="1.1">
            <defs>
            <filter id="goo-12">
                <feGaussianBlur in="SourceGraphic" stdDeviation="4" result="blur"></feGaussianBlur>
                <feColorMatrix in="blur" mode="matrix" values="1 0 0 0 0  0 1 0 0 0  0 0 1 0 0  0 0 0 22 -7" result="goo-12"></feColorMatrix>
                <feBlend in="SourceGraphic" in2="goo-12"></feBlend>
            </filter>
            </defs>
        </svg>
        <div>
            <label for="cbx-12"  style={{margin: 0, paddingLeft: "0.4rem", fontSize: 15, fontWeight:"500"}}>{text}</label> 
        </div>
    </div>
  )
}

export default CheckBoxTool1