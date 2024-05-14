'use client';

import React from 'react';
import { Box, Grid, Typography, Container, IconButton } from '@mui/material';
import LocationOnIcon from '@mui/icons-material/LocationOn';
import EmailIcon from '@mui/icons-material/Email';
import PhoneIcon from '@mui/icons-material/Phone';

export default function ContactPage() {
    const handleLocationClick = () => {
        window.open('https://www.google.com/maps/place//data=!4m2!3m1!1s0x47455d82fd425403:0xebeab37fb452ca7a?sa=X&ved=1t:8290&ictx=111', '_blank');
    };

    const handleEmailClick = () => {
        window.location.href = 'mailto:support@dinein.com';
    };

    const handlePhoneClick = () => {
        window.location.href = 'tel:+40712345678';
    };

    return (
        <Container
            maxWidth="md"
            sx={{
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'center',
                height: '100vh', // Full viewport height
            }}
        >
            <Grid container spacing={4}>
                <Grid item xs={12} sm={4}>
                    <Box
                        textAlign="center"
                        p={2}
                        bgcolor="background.paper"
                        boxShadow={3}
                        borderRadius={2}
                        height={200} // Ensure all boxes have the same height
                    >
                        <IconButton onClick={handleLocationClick}>
                            <LocationOnIcon fontSize="large" color="primary" />
                        </IconButton>
                        <Typography variant="h6" mt={1} color="text.primary">Address</Typography>
                        <Typography variant="body1" color="text.primary">Piața Victoriei 2, Timișoara 300006</Typography>
                    </Box>
                </Grid>
                <Grid item xs={12} sm={4}>
                    <Box
                        textAlign="center"
                        p={2}
                        bgcolor="background.paper"
                        boxShadow={3}
                        borderRadius={2}
                        height={200} // Ensure all boxes have the same height
                    >
                        <IconButton onClick={handleEmailClick}>
                            <EmailIcon fontSize="large" color="primary" />
                        </IconButton>
                        <Typography variant="h6" mt={1} color="text.primary">Email</Typography>
                        <Typography variant="body1" color="text.primary">support@dinein.com</Typography>
                    </Box>
                </Grid>
                <Grid item xs={12} sm={4}>
                    <Box
                        textAlign="center"
                        p={2}
                        bgcolor="background.paper"
                        boxShadow={3}
                        borderRadius={2}
                        height={200} // Ensure all boxes have the same height
                    >
                        <IconButton onClick={handlePhoneClick}>
                            <PhoneIcon fontSize="large" color="primary" />
                        </IconButton>
                        <Typography variant="h6" mt={1} color="text.primary">Phone</Typography>
                        <Typography variant="body1" color="text.primary">+40712345678</Typography>
                    </Box>
                </Grid>
            </Grid>
        </Container>
    );
}
