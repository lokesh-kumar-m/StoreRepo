import './card.css'
const Card=({name,cost,quantity})=>{
    return(
        <div>
            <div className="card">
          <h2>{name}</h2>
          <p>Price: {cost} rupees</p>
          <p>Available: {quantity}</p>
          <button className='addtocard'>Add</button>
        </div>
        </div>
    )
}
export default Card