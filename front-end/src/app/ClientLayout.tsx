"use client";

import React from "react";
import { ThemeProvider } from "@emotion/react";
import { DineInTheme } from "@/utils/theme";

const ClientLayout = ({ children }: { children: React.ReactNode }) => {
  return (
    <ThemeProvider theme={DineInTheme}>
        {children}
    </ThemeProvider>
  );
};

export default ClientLayout;
