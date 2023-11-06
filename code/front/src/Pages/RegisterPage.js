import axios from 'axios';
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import api from '../api';


function AddStaff() {

    let navigate = useNavigate();

    const [user, setUsers] = useState({
        firstname:"",
        lastname:"",
        username:"",
        email:"",
        password:"",
        role:""
    });

    const{firstname, lastname, username, password,email, role} = user;

    const onInputChange = (e) =>{
        setUsers({...user, [e.target.name]:e.target.value});
    };


    const onSubmit= async(e) => {
        e.preventDefault();
        await axios.post("http://localhost:8082/api/v1/auth/signup",user);
        navigate('/login');
    };

    return (

        <div className='container'>
            <div className='row'>
                <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>

                    <h2 className='text-center m-4'>Registration</h2>

                    <form onSubmit={(e) => onSubmit(e)}>

                        <div className='mb-3'>
                            <label htmlFor="firstname" className='form-label'>
                                First Name
                            </label>
                            <input
                                type={"text"}
                                className='form-control'
                                placeholder='Enter Firstname'
                                name='firstname'
                                value={firstname}
                                onChange={(e)=> onInputChange(e)}>
                            </input>
                        </div>

                        <div className='mb-3'>
                            <label htmlFor="lastname" className='form-label'>
                                Last Name
                            </label>
                            <input
                                type={"text"}
                                className='form-control'
                                placeholder='Enter Lastname'
                                name='lastname'
                                value={lastname}
                                onChange={(e)=> onInputChange(e)}>
                            </input>
                        </div>

                        <div className='mb-3'>
                            <label htmlFor="Email" className='form-label'>
                                Email
                            </label>
                            <input
                                type={"text"}
                                className='form-control'
                                placeholder='Enter Email'
                                name='email'
                                value={email}
                                onChange={(e)=> onInputChange(e)}>
                            </input>
                        </div>

                        <div className='mb-3'>
                            <label htmlFor="username" className='form-label'>
                                Username
                            </label>
                            <input
                                type={"text"}
                                className='form-control'
                                placeholder='Enter Username'
                                name='username'
                                value={username}
                                onChange={(e)=> onInputChange(e)}>
                            </input>
                        </div>

                        <div className='mb-3'>
                            <label htmlFor="password" className='form-label'>
                                Password
                            </label>
                            <input
                                type={"text"}
                                className='form-control'
                                placeholder='Enter Password'
                                name='password'
                                value={password}
                                onChange={(e)=> onInputChange(e)}>
                            </input>
                        </div>

                        <div className='mb-3'>
                            <label htmlFor="role" className='form-label'>
                                Role
                            </label>
                            <input
                                type={"text"}
                                className='form-control'
                                placeholder='Enter Role'
                                name='role'
                                value={role}
                                onChange={(e)=> onInputChange(e)}>
                            </input>
                        </div>

                        <button type='submit' className='bnt btn-outline-primary'>
                            Register
                        </button>

                        <Link className='bnt btn-outline-danger mx-2' to='/login'>
                            Cancel
                        </Link>
                    </form>

                </div>
            </div>
        </div>


    )
}

export default AddStaff;