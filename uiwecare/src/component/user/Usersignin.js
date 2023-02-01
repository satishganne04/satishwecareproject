import axios from 'axios';
import { useState } from 'react';



function Usersignin() {
    const [id, setId] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.get('http://localhost:8066/user/login', {
                params: {
                    id,
                    password
                }
            });
            console.log(response);
        } catch (error) {
            console.error(error);
        }
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                Id:
                <input type="text" value={id} onChange={(e) => setId(e.target.value)} />
            </label>
            <br />
            <label>
                Password:
                <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
            </label>
            <br />
            <button type="submit">Submit</button>
        </form>
    );
}

export default Usersignin;
