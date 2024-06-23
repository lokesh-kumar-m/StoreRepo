import { useEffect, useState } from "react";
import Header from "../Header/Header";
import Card from "./card";
import { GetProducts } from "../api/productApiService";

const Home = () => {
    const [prods, setProducts] = useState([])
    useEffect(() => {
        GetProducts().then(response => {
            setProducts(response.data);
        })
            .catch(error => {
                console.error("Error fetching products", error);
            });
    }, []);

    return (
        <div>
            <Header />
            <div className="main_Heading">
                <h1>Welcome to the Store</h1>
            </div>
            <div>
                <main>
                    <div className="grid-container">
                        {prods.map((prod,id) => <Card key={id} name={prod.name} quantity={prod.numbers} cost={prod.price} />)}
                    </div>
                </main>
            </div>
        </div>
    );
}

export default Home;