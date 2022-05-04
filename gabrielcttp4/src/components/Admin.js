import React from "react";
import NewCd from "./NewCd";
import NewClient from "./NewClient";
import NewDvd from "./NewDvd";
import NewLivre from "./NewLivre";

const Admin = () => (
    <div>
        <h2>Admin Pannel</h2>
        <NewClient/>
        <NewLivre/>
        <NewCd/>
        <NewDvd/>
    </div>
)

export default Admin;