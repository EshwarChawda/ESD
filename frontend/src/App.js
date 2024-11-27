import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginPage from './components/LoginPage';
import Courses from './components/Courses';

function App() {
  return (
    <Router>
    <div className="App">
      <Routes>
        <Route path="/" element={<LoginPage />} />
        <Route path="/courses/:username" element={<Courses />} />
      </Routes>
    </div>
  </Router>
  );
}

export default App;
