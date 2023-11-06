import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './Layout/Navbar';
import HomePage_Manager from './Pages/HomePage_Manager';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AddStaff from './Users/AddStaff';
import EditStaff from './Users/EditStaff';
import ViewStaff from './Users/ViewStaff';
import LoginPage from './Pages/LoginPage';
import RegisterPage from './Pages/RegisterPage';
import HomePage_Staff from './Pages/HomePage_Staff';
import { Component } from 'react';


function App() {
    return (
        <div className="App">
            <Router>


                <Routes>
                    <Route path="/login" element={<LoginPage />} />
                    <Route path="/home" element={<HomePage_Manager />} />
                    <Route path="/addStaff" element= { <AddStaff />} />
                    <Route path="/editstaff/:id" element={<EditStaff />} />
                    <Route path='/viewstaff/:id' element={<ViewStaff />} />
                    <Route path='/registration' element={<RegisterPage />} />
                    <Route path='/staff' element={<HomePage_Staff />} />
                </Routes>

            </Router>



        </div>
    );
}

export default App;


