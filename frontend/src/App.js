import React from 'react';
import MiniDrawer from './Component/Drawer';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import WriteCard from './Component/WriteCard';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form'
import RegisterPage from './Pages/RegisterPage';
import MainPage from './Pages/MainPage';
import LoginPage from './Pages/LoginPage';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';

export default function App() {
  return (
    <div >
      <Router>
        <div>
            <Switch>
                <Route path="/login" exact component={LoginPage}/>
                <Route path="/u/**" exact component={MiniDrawer}/>
                <Route path="/register" component={RegisterPage}/>
              </Switch>
          </div>
      </Router>
    </div>
  );
}

