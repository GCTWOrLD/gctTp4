import React from 'react';
import {NavLink} from 'react-router-dom';

const Header = () => {
    const blue = "#89CFF0"
    const red = "#F12B2A"
    const navLinkStyles = ({isActive}) => {
        console.log(isActive)
        return {
            fontWeight: isActive ? "bold" : "normal",
            textDecoration: isActive ? "none" : "underline",
            color: isActive ? `${red}` : `${blue}`
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