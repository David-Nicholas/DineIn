import React from 'react';
import { Box, Container, Typography } from '@mui/material';
import CustomButton from '@/components/moleculas/CustomButton';
import { fetchData } from '@/api/apiClient';
import { Restaurant } from "@/app/restaurants/list/page";

async function GetNode(nodeId: string): Promise<Restaurant> {
    const data = await fetchData(`/restaurants/${nodeId}`);
    return data;
}

export default async function Page({ params }: { params: { id: string } }) {
    const data = await GetNode(params.id);

    const [description, menuUrl, phoneNumber] = data.description.split(', ').map(part => part.trim());

    return (
        <Container maxWidth="sm" sx={{ textAlign: 'center', mt: 4 }}>
            <Typography variant="h4" component="h1" gutterBottom>
                {data.name}
            </Typography>

            <Box
                component="img"
                sx={{
                    height: 400,
                    width: 550,
                    maxHeight: { xs: 250, md: 400 },
                    maxWidth: { xs: 300, md: 550 },
                    borderRadius: 2,
                }}
                alt={data.name}
                src={`http://localhost:8080/images/${data.imageUrl}`}
            />

            <Box sx={{ display: 'flex', justifyContent: 'space-around', mt: 2, mb: 2 }}>
                <CustomButton text='BOOK NOW' route={`/reservations/${params.id}`}/>
                <CustomButton text='CALL' route={`tel:${phoneNumber}`}/>
                <CustomButton text='VIEW MENU' route={menuUrl}/>
            </Box>

            <Box sx={{ p: 2, border: '1px solid grey', borderRadius: 2 }}>
                <Typography variant="body1" align="center">
                    {description}
                </Typography>
            </Box>
        </Container>
    );
}