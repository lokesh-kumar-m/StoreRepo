import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { AddNewUser } from "../api/userApiService";

const RegisterUser=()=>{
    const [name,setName]=useState("")
    const [password,setPassword]=useState("")
    const navigateTo=useNavigate()
    function handleSignup(){
        const USER={
            username:name,
            password:password
        }
        AddNewUser(USER).then(
            (response)=>isCreated(response)
        ).catch(
            (error)=>console.log(error)
        )
    }
    function isCreated(response){
        if(response.status==200){
            navigateTo(`/users/login`)
        }else{
            console.log("error! Invalid credentials")
        }
    }
    function gotoLogin(){
        navigateTo(`/users/login`)
    }
    return(
        <div className="login-card">
        <h2>Register User</h2>
        <div>
            <div className="input-group">
                <label>Username</label>
                <input type="text" id="username" name="username" value={name} onChange={(e)=>setName(e.target.value)}/>
            </div>
            <div className="input-group">
                <label >Password</label>
                <input type="password" id="password" name="password" value={password} onChange={(e)=>setPassword(e.target.value)}/>
            </div>
            <div className="button-group">
                <button type="button" onClick={handleSignup}>Sign Up</button>
                <button onClick={gotoLogin}>Log in</button>
            </div>
        </div>
    </div>
    );
}
export default RegisterUser