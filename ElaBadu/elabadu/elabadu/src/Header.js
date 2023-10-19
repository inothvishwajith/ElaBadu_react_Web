
import React, { useEffect, useState } from "react";
import "./Header.css";
import SearchIcon from "@material-ui/icons/Search";
import ShoppingBasketIcon from "@material-ui/icons/ShoppingBasket";
import { Link, useLocation } from "react-router-dom";
import { useStateValue } from "./StateProvider";
import { auth } from "./firebase";
import logo from "./img/hlogo.png";

function Header(props) {
  const [{ basket, user }, dispatch] = useStateValue();
  const location = useLocation()
  const [email, setEmail] = useState('')


  useEffect(() => {
    // console.log(location.state.email);
    if (location.state != undefined) {
      setEmail(location.state.email)
    }
  }, [])

  return (
    <div className="header">
      <Link to="/">
        <img
          className="header__logo"
          src={logo} alt="logo"
        />
      </Link>
      <Link to='/admin-login'>
        <div className="header__option">
          <span className="header__optionLineOne">System</span>
          <span className="header__optionLineTwo">ADMIN</span>
        </div>
      </Link>

      <div className="header__search">
        <input className="header__searchInput" type="text" />
        <SearchIcon className="header__searchIcon" />
      </div>

      <div className="header__nav">
        <Link to={'/login'}>
          <div className="header__option">
            <span className="header__optionLineOne">Hello {!email ? 'Guest' : email}</span>
            <span className="header__optionLineTwo">{email ? 'Sign Out' : 'Sign In'}</span>
          </div>
        </Link>

        <Link to='/orders'>
          <div className="header__option">
            <span className="header__optionLineOne">Returns</span>
            <span className="header__optionLineTwo">& Orders</span>
          </div>
        </Link>

        <Link to="/checkout">
          <div className="header__optionBasket">
            <ShoppingBasketIcon />
            <span className="header__optionLineTwo header__basketCount">
              {basket?.length}
            </span>
          </div>
        </Link>
      </div>
    </div>
  );
}

export default Header;