"use client";

import React from "react";
import { ThemeProvider } from "@emotion/react";
import { DineInTheme } from "@/utils/theme";
import Navbar from "@/components/Navbar";

const ClientLayout = ({ children }: { children: React.ReactNode }) => {
  return (
    <ThemeProvider theme={DineInTheme}>
      <Navbar></Navbar>
        {children}
    </ThemeProvider>
  );
};

export default ClientLayout;
