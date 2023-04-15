import React, {useState} from 'react'

const InputTools = ({title, state, setState, type, width, minLength, style}) => {
  const [isValid, setIsValid] = useState(true);
  const changeHandler = (e) => {
    if (e.target.value.length < minLength) {
      setIsValid(false);
    } else {
      setIsValid(true);
    }
    setState(e.target.value);
  }
  return (
    <div className="wave-group" style={style}>
      <input required type={type} value={state} className="input" style={{width:`${width}px`}} onChange={changeHandler} minLength={minLength}/>
      <span className="bar" style={{ width, backgroundColor: isValid ? '' : 'red' }}
    ></span>
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