import React, { useState } from 'react';
import axios from 'axios';
import './LoginForm.css';

function LoginForm() {
    const [id, setId] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');

        if (!id) {
            setError('ID is required');
            return;
        }

        if (password.length < 5 || password.length > 10) {
            setError('Password should have 5 to 10 characters');
            return;
        }

        try {
            const response = await axios.get('http://localhost:8077/coaches/login', {
                params: {
                    id,
                    password
                }
            });
            if (response.status === 200) {
                // handle successful login
            }
        } catch (err) {
            setError(err.response.data);
        }
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                ID:
                <input type="number" value={id} onChange={e => setId(e.target.value)} required />
            </label>
            <br />
            <label>
                Password:
                <input type="password" value={password} onChange={e => setPassword(e.target.value)} required />
            </label>
            <br />
            <button type="submit">Login</button>
            {error && <p>{error}</p>}
        </form>
    );
}

export default LoginForm;
