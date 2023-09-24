import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"; 
import Navbar from './Layout/Navbar';
import HomePage_Manager from './Pages/HomePage_Manager';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import AddStaff from './Users/AddStaff';
import EditStaff from './Users/EditStaff';
import ViewStaff from './Users/ViewStaff';

{/*these are Comments*/}

function App() {
  return (
    <div className="App">
      <Router>

      <Navbar /> 
      <Routes>

      {/*different url paths to each js. page element */}
        <Route path="/" element={<HomePage_Manager />} />
        <Route path="/addStaff" element= { <AddStaff />} />
        <Route path="/editstaff/:id" element={<EditStaff />} />
        <Route path='/viewstaff/:id' element={<ViewStaff />} />
      </Routes>
      
      </Router>



    </div>
  );
}

export default App;


