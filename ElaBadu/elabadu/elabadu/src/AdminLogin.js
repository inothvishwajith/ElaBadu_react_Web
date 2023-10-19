import React, { useState } from 'react';
import './Login.css'
import { Link, useHistory } from "react-router-dom";
import { auth } from "./firebase";
import logo from "./img/logo.png";
import UserService from './services/UserService';
import ConditionalLink from './components/ConditionalLink';
import { useStateValue } from './StateProvider';
import { useSnackbar } from 'react-simple-snackbar'

function AdminLogin() {
    const history = useHistory();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [{ user }, dispatch] = useStateValue();
    const options = {
        position: 'bottom-right',
        style: {
            backgroundColor: '#259f00',
            color: '#ffff',
            fontFamily: 'Menlo, monospace',
            fontSize: '20px',
            textAlign: 'center',
        },
        closeStyle: {
            color: '#be0003',
            fontSize: '16px',
        },
    }
    const [openSnackbar, closeSnackbar] = useSnackbar(options)


    const signIn = e => {
        e.preventDefault();
        // alert(JSON.stringify(email))
        if (email == "admin@gmail.com" && password == "admin123") {
            openSnackbar('Logged As admin.')
            history.push("/users")
        }
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

                    <button type='submit' onClick={signIn} className='login__signInButton'>Admin Sign In</button>
                </form>

            </div>

        </div>
    )
}
export default AdminLogin;
