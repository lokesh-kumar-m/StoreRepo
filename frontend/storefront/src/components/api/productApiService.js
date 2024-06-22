import { apiContext } from "./apiContext";

export const GetProducts=()=>apiContext.get("/products")