import { useEffect, useState } from "react";
import Header from "../Header/Header";
import { useAuth } from "../auth";
import { MyCart } from "../api/cartApiService";
import CartItem from "./cartItem";
import { DeleteProd } from "../api/cartApiService"
const Cart = () => {
    const authContext=useAuth();
    const [myList,setList]=useState([])
    useEffect(()=>{
        MyCart(authContext.username).then(
            (response)=>{setList(response.data)}
        ).catch(
            (error)=>console.log(error)
        )
    },[])

    function handleDelete(id){
        DeleteProd(id).then(
            (response)=>{ console.log("deleted")}
        ).catch(
            (error)=>{console.log(error)}
        )
        setList((prev)=>{
            const filterList=prev.filter((item)=>item.userId!=id)
            return filterList
        })
    }
    return (
        <div>
            <Header />
            <h1> {authContext.username} Cart</h1>
            <div className="cart-container">
                {myList.length>0?myList.map((item,id)=>
            <CartItem
                key={id}
                prodName={item.productName}
                quantity={item.quantity}
                price={item.cost}
                itemId={item.userId}
                handleDelete={handleDelete}
            />):<h1>Your Cart is Empty</h1>}
            {}
            </div>
        </div>
    )
}
export default Cart;