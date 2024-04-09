"use client";

import React from "react";
import { ThemeProvider } from "@emotion/react";
import { DineInTheme } from "@/utils/theme";
import Navbar from "@/components/organisms/Navbar";
import Footer from "@/components/organisms/Footer";
import {Main} from "@/components/layouts/Main";
import Root from "@/components/layouts/Root";

const ClientLayout = ({ children }: { children: React.ReactNode }) => {
  return (
    <ThemeProvider theme={DineInTheme}>
      <Root>
        <Navbar/>
        <Main>
          {children}
        </Main>
        <Footer/>
      </Root>
    </ThemeProvider>
  );
};

export default ClientLayout;
