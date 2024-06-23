import './card.css'
import { AddToCart } from '../api/cartApiService'
import { useAuth } from '../auth'

const Card = ({ name, cost, quantity }) => {
    const authContext=useAuth()
    function handleAddingToCart(){
        const Prod={
            userName:authContext.username,
            productName:name,
            cost:cost,
            quantity:quantity
        }
        AddToCart(Prod).then(
            (response)=>{console.log(response.data)}
        ).catch(
            (error)=>{console.log(error)}
        )
    }
    return (
        <div>
            <div className="card">
                <h2>{name}</h2>
                <p>Price: {cost} rupees</p>
                <p>Available: {quantity}</p>
                <button className='addtocard' onClick={handleAddingToCart}>Add</button>
            </div>
        </div>
    )
}
export default Card