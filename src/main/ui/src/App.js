import React from 'react';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import Home from './pages/Home'
function App() {
  return (

        <Router>
            <div>
<header>
    <h1>A-Mail</h1>
</header>

    <Routes>
        <Route path='/' element={<Home/>}/>
    </Routes>
            </div>
</Router>

  );
}

export default App;
