"use client";

import React from "react";
import { ThemeProvider } from "@emotion/react";
import { DineInTheme } from "@/utils/theme";
import Navbar from "@/components/organisms/Navbar";
import Footer from "@/components/organisms/Footer";
import {Main} from "@/components/layouts/Main";

const ClientLayout = ({ children }: { children: React.ReactNode }) => {
  return (
    <ThemeProvider theme={DineInTheme}>
      <Navbar/>
      <Main>
        {children}
      </Main>
      <Footer/>
    </ThemeProvider>
  );
};

export default ClientLayout;
