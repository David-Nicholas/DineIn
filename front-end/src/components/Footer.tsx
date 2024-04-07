import React, { FC, ReactElement } from "react";
import { Box, Container, Grid, Typography } from "@mui/material";
import InstagramIcon from '@mui/icons-material/Instagram';
import FacebookIcon from '@mui/icons-material/Facebook';
import Link from '@mui/material/Link';

export const Footer: FC = (): ReactElement => {
  return (
    <Box
      sx={{
        width: "100%",
        height: "auto",
        backgroundColor: "#2074d4",
        paddingTop: "1rem",
        paddingBottom: "1rem",
      }}
    >
      <Container maxWidth="lg">
        <Grid container direction="column" alignItems="center">
          <Grid item xs={12}>
            <Typography
                sx={{
                    display: "inline-flex",
                    alignItems: "center",
                    gap: "0.7rem"
                  }}
            >
                <Link href="https://www.instagram.com/" color="inherit" underline="none"><InstagramIcon/></Link>
                <Link href="https://www.facebook.com/" color="inherit" underline="none"><FacebookIcon/></Link>
            </Typography>
          </Grid>
          <Grid item xs={12}>
            <Typography
              color="inherit"
              variant="subtitle1"
              fontFamily="monospace"
              fontWeight={400}
            >
              {`@${new Date().getFullYear()} DineIn`}
            </Typography>
          </Grid>
        </Grid>
      </Container>
    </Box>
  );
};

export default Footer;
