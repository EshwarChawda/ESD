import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginPage from './components/LoginPage';
import Courses from './components/Courses';
import TAList from './components/TAList';


function App() {
  return (
    <Router>
    <div className="App">
      <Routes>
        <Route path="/" element={<LoginPage />} />
        <Route path="/courses/:username" element={<Courses />} />
        <Route path="/courses/:facCode/:courseId" element={<TAList />} />
      </Routes>
    </div>
  </Router>
  );
}

export default App;
