import React from 'react';
import {NavLink} from 'react-router-dom';

const Header = () => {
    const red = "#FF0000"
    const black = "#000000"
    const navLinkStyles = ({isActive}) => {
        console.log(isActive)
        return {
            fontSize: "20px",
            fontWeight: isActive ? "bold" : "normal",
            textDecoration: isActive ? "none" : "underline",
            backgroundColor: isActive ? "black" : "white",
            color: isActive ? `${red}` : `${black}`
        }
    }
    return (
        <div>
            <NavLink to="/" style={navLinkStyles}>Home</NavLink>{" | "}
            <NavLink to="/admin" style={navLinkStyles}>Admin</NavLink> {" | "}
            <NavLink to="/client" style={navLinkStyles}>Client</NavLink>
        </div>
    )
}

export default Header;