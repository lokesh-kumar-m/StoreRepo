import React, { useState, useEffect } from "react";
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom"
import Login from "./components/login/login";
import RegisterUser from "./components/Register/register";
import Home from "./components/Home/home";
import Cart from "./components/Home/cart";
import './App.css';
import Auth,{useAuth} from './components/auth';

function AuthenticatedRoutes({children}){
  const authContext=useAuth()
  if(authContext.isAuthentic){
      return children
  }
  return <Navigate to="/"></Navigate>
}

function App() {

  return (
    <div>
      <Auth>
        <BrowserRouter>
          <Routes>
            <Route path='/' element={<RegisterUser />} />
            <Route path='/users/register' element={<RegisterUser />} />
            <Route path='/users/login' element={<Login />} />
            <Route path='/welcome/:username' element={
              <AuthenticatedRoutes>
                <Home></Home>
              </AuthenticatedRoutes>
            }/>
            <Route path='/cart/:username' element={
              <AuthenticatedRoutes>
                <Cart></Cart>
              </AuthenticatedRoutes>
            }/>
          </Routes>
        </BrowserRouter>
      </Auth>
    </div>
  );
}

export default App;
