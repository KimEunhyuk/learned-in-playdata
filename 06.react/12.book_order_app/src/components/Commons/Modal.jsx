import React from 'react'
import classes from './Modal.module.css'
import ReactDOM from 'react-dom'

const Background = (props) => {
  return <div className={classes.background} onClick={props.onClose}/>
}

const ModalWindow = (props) => {
    return(
        <div className={classes.modal}>
            <div className={classes.content}>{props.children}</div>
        </div>
    )
}

const portalElement = document.getElementById('modal-window')

const Modal = (props) => {
  return (
    <>
      {ReactDOM.createPortal(<Background onClose={props.onClose}/>, portalElement)}
      {ReactDOM.createPortal(<ModalWindow>{props.children}</ModalWindow>, portalElement)}
    </>
  )
}

export default Modal