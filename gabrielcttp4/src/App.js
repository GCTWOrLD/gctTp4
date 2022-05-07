import './App.css';
import Footer from './components/Footer';
import Header from './components/Header'
import {Route, Routes} from "react-router-dom";
import HomePage from "./components/HomePage";
import Admin from "./components/Admin";
import Client from "./components/Client";
import PageNotFound from "./components/PageNotFound";

function App() {
  return (
    <div >
      <header >
          <h1>Bibliothèque Javatown</h1>
          <Header/>
      </header>

      <Routes>
          <Route path="/" element={<HomePage/>} />
          <Route path="/admin" element={<Admin/>} />
          <Route path="/client" element={<Client/>} />
          <Route path="*" element={<PageNotFound/>} />
      </Routes>
      <Footer/>
    </div>
  );
}

export default App;
