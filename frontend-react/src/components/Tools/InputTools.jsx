import React from 'react'

const InputTools = ({title, state, setState, type,width}) => {

  return (
    <div className="wave-group">
      <input required type={type} className="input" style={{width:`${width}px`}}/>
      <span className="bar"></span>
      <label className="label">
        {title.split('').map((char, index) => (
          <span
            key={index}
            className={`label-char${char === ' ' ? ' label-char-space' : ''}`}
            style={{ '--index': index }}
          >
            {char}
          </span>
        ))}
      </label>
    </div>
  );
}

export default InputTools