import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import LoggedOutNavBar from './LoggedOutNavBar';
import LoggedInNavBar from './LoggedInNavBar';

const HomePage = ({ loggedInUser }) => {
    return (
        <>
            <AppBar position="relative">
                {loggedInUser ? <LoggedInNavBar /> : <LoggedOutNavBar />}
            </AppBar>
        </>
    )
}

export default HomePage