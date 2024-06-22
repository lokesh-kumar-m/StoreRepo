
import { useNavigate,Link } from "react-router-dom";
import { useAuth } from "../auth";
import "./header.css"
const Header= () =>{
    const authContext=useAuth()
    const navigateTo=useNavigate()

    function handlelogout(){
        authContext.islogout()
        navigateTo(`/users/login`)
    }
    return(
        <header className="header">
        <nav className="nav container">
          <Link to={`/welcome/${authContext.username}`} className="nav-logo">Store</Link>
          
          <div className="nav-menu">
            <ul className="nav-list">
              <li className="nav-item">
                <Link to={`/welcome/${authContext.username}`} className='nav-link active-link'>{authContext.username}</Link>
              </li>
                <li className="nav-item">
                    <Link to={`/cart/${authContext.username}`} className='nav-link active-link'>Cart</Link>
                </li>
              <li className="nav-item">
                <button className="btn"onClick={handlelogout}>Logout</button>
                
              </li>
            </ul>
          </div>
          
        </nav>
      </header>
    )
}
export default Header;