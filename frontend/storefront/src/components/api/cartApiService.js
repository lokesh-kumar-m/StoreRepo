import { apiContext } from "./apiContext";

export const AddToCart=(Prod)=>apiContext.post(`/add/item`,Prod)
export const MyCart=(name)=>apiContext.get(`/mylist/${name}`)
export const DeleteProd=(id)=>apiContext.delete(`/delete/${id}`)