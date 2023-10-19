import React, { useState } from 'react';
import './Login.css'
import { Link, useHistory } from "react-router-dom";
import { auth } from "./firebase";
import logo from "./img/logo.png";
import UserService from './services/UserService';
import ConditionalLink from './components/ConditionalLink';
import { useStateValue } from './StateProvider';

function Login() {
    const history = useHistory();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [{ user }, dispatch] = useStateValue();

    const signIn = e => {
        e.preventDefault();
        // alert(JSON.stringify(email))
        UserService.getUserByEmail(email)
            .then((res) => {
                res.data.forEach(customer => {
                    password ? customer.password == password ? loginInit(customer) : '' : ''
                });
            })
    }

    const loginInit = (customer) => {
        history.push('/', customer)
        dispatch({
            type: "SET_USER",
            user: {
                id: customer.id,
                name: customer.name,
                email: customer.email,
                password: customer.password,
                address: customer.address
            },
        });
    }

    const register = e => {
        e.preventDefault();

        auth
            .createUserWithEmailAndPassword(email, password)
            .then((auth) => {
                // it successfully created a new user with email and password
                if (auth) {
                    history.push('/')
                }
            })
            .catch(error => alert(error.message))
    }

    return (
        <div className='login'>
            <Link to='/'>
                <img
                    className="login__logo"
                    src={logo} alt='logo'
                />
            </Link>
            <div className='login__container'>
                <h1>Sign-in</h1>

                <form>
                    <h5>E-mail</h5>
                    <input type='text' value={email} onChange={e => setEmail(e.target.value)} />

                    <h5>Password</h5>
                    <input type='password' value={password} onChange={e => setPassword(e.target.value)} />

                    <button type='submit' onClick={signIn} className='login__signInButton'>Sign In</button>
                </form>

                <p>
                    By signing-in you agree to the elabadu Conditions of Use & Sale. Please
                    see our Privacy Notice, our Cookies Notice and our Interest-Based Ads Notice.
                </p>
                <Link to='/register'>
                    <button  /* onClick={register} */ className='login__registerButton'>Create your Elabadu Account</button>
                </Link>
            </div>

        </div>
    )
}
export default Login;
