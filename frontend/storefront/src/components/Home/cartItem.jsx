import { useState } from "react"


const CartItem=({prodName,quantity,price,itemId,handleDelete})=>{
    const [quant,setQuant]=useState(1)
    function increament(){
        if(quant+1<quantity)
        setQuant((prev)=>{return prev+1})
    }
    function decrement(){
        if(quant-1>0)
            setQuant((prev)=>{return prev-1})
    }
    return(
        <div>
            <div className="cart-item">
          <div className="item-info">
            <h2>{prodName}</h2>
          </div>
          <div className="item-details">
            <div>
                <button className="quantControl" onClick={increament}>+</button>
                <span>{quant}</span>
                <button className="quantControl"  onClick={decrement}>-</button>
            </div>
            <span>Cost: {price*quant} INR</span>
            <button className="delete-btn" onClick={()=>handleDelete(itemId)}>Delete</button>
          </div>
        </div>
        </div>
    )
}

export default CartItem