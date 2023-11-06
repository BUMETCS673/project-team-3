import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {Link, useParams} from "react-router-dom";
import Navbar from '../Layout/Navbar';
import api from '../api';



export default function HomePage_Manager() {

    const{id} = useParams();

    const[users, setUsers] = useState([])

    useEffect(() =>{
        loadStaff();
    },[])


    const loadStaff = async() =>{
        try {
            const result = await api.get("/admin/allemployee");
            setUsers(result.data);
        } catch (error) {
            console.log("error from homepage_manager");
        }
    };

    const deleteUser = async(id)=>{
        try {
            await api.delete(`/admin/${id}`);
            loadStaff();
        } catch (error) {
            console.log(error);
        }
    };


    return (
        <div className='container'>

            <Navbar />

            <div className='py-4'>
                <table className="table border shadow">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Job Title</th>
                        <th scope="col">Annual Salary</th>
                    </tr>
                    </thead>
                    <tbody>

                    {users.map((user, index) => (
                        <tr>
                            <th scope="row" key={index}> {index+1} </th>
                            <td>{user.id}</td>
                            <td>{user.name}</td>
                            <td>{user.jobTitle}</td>
                            <td>${user.annualSalary}</td>

                            <td>
                                <Link className='btn btn-primary mx-2'
                                      to={`/viewstaff/${user.id}`}>
                                    View Employee
                                </Link>

                                <Link className='btn btn-outline-primary mx-2'
                                      to={`/editstaff/${user.id}`}>
                                    Edit Employee
                                </Link>

                                <button className='btn btn-outline-danger mx-2'
                                        onClick={()=>deleteUser(user.id)}>
                                    Delete Employee
                                </button>

                            </td>

                        </tr>
                    ))
                    }

                    </tbody>
                </table>
            </div>

        </div>
    )
}
