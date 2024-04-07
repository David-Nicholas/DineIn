"use client";

import React from "react";
import { ThemeProvider } from "@emotion/react";
import { DineInTheme } from "@/utils/theme";
import Navbar from "@/components/Navbar";
import Footer from "@/components/Footer";

const ClientLayout = ({ children }: { children: React.ReactNode }) => {
  return (
    <ThemeProvider theme={DineInTheme}>
      <Navbar/>
        {children}
      <Footer/>
    </ThemeProvider>
  );
};

export default ClientLayout;
