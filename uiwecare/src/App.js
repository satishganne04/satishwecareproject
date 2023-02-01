
import {BrowserRouter as Router ,Route} from 'react-router-dom';
import './App.css';
import Coachsignup from './component/coach/Coachsignup';
import LoginForm from './component/coach/LoginForm';
import CoachHome from './component/homepages/CoachHome';
import Home from './component/homepages/Home';
import UserHome from './component/homepages/UserHome';
import UserProfile from './component/homepages/UserProfile';
import Navbar from './component/navbar/Navbar';
import Usersignin from './component/user/Usersignin';
import Usersignup from './component/user/Usersignup';






function App() {
  return (
    
    <>
 <Navbar/>
 
 <Router>
   
 <Route exact path="/" element={<Home/>} />
          <Route exact path="/coachsignup" element={<Coachsignup/>} />
          <Route exact path="/coachlogin" element={<LoginForm/>} />
          <Route exact path="/coachhome" element={<CoachHome/>} />
          <Route exact path="/usersignup" element={<Usersignup/>} />
          <Route exact path="/userlogin" element={<Usersignin/>} />
          <Route exact path="/userhome" element={<UserHome/>} />  
          <Route exact path="/userviewprofile" element={<UserProfile/>} />  
 </Router>
 </>
  )
}

export default App;
