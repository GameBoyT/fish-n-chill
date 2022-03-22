import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import UnregNavBar from './UnregNavBar';
import RegNavBar from './RegNavBar';

const HomePage = ({ loggedInUser }) => {
    return (
        <>
            <AppBar position="relative">
                {loggedInUser ? <RegNavBar /> : <UnregNavBar />}
            </AppBar>
        </>
    )
}

export default HomePage