import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import Menu from '@mui/material/Menu';
import MenuIcon from '@mui/icons-material/Menu';
import Container from '@mui/material/Container';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import Tooltip from '@mui/material/Tooltip';
import MenuItem from '@mui/material/MenuItem';
import AdbIcon from '@mui/icons-material/Adb';
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import Badge from '@mui/material/Badge';
import { styled } from '@mui/material/styles';
import { useSelector, useDispatch } from "react-redux"
import { incrementBasketCount } from './store/mainstore';
import { useNavigate } from 'react-router-dom';
import PersonIcon from '@mui/icons-material/Person';


const pages = [];
const StyledBadge = styled(Badge)(({ theme }) => ({
  '& .MuiBadge-badge': {
    right: -3,
    top: 13,
    border: `2px solid ${theme.palette.background.paper}`,
    padding: '0 4px',
  },
}));

const Navbar = () => {
  const navigate = useNavigate();
  const { basketCount } = useSelector(state => state.mainStore);
  const [anchorElNav, setAnchorElNav] = React.useState(null);
  const [anchorElUser, setAnchorElUser] = React.useState(null);

  const handleOpenNavMenu = (event) => {
    setAnchorElNav(event.currentTarget);
  };
  const handleOpenUserMenu = (event) => {
    setAnchorElUser(event.currentTarget);
  };

  const handleCloseNavMenu = () => {
    setAnchorElNav(null);
  };

  const handleCloseUserMenu = () => {
    setAnchorElUser(null);
  };

  const clickCartBtn = () => {
    navigate("/cartdetail");
  };

  const clickUserBtn = () => {
    navigate("/user");
  };

  return (
    <AppBar position="static" style={{backgroundColor: "#1b2c3d"}}>
      {/* <div style={{display: "flex", width: "100vw", justifyContent:"center", paddingTop: "0.5rem"}}>
        <p style={{margin: 0, fontWeight: "bolder", color: "#40d6b9"}}>100₺ Üzeri Alışverişlerde Kargo Bedava!</p> 
      </div> */}
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          {/* <AdbIcon sx={{ display: { xs: 'none', md: 'flex' }, mr: 1 }} /> */}
          <Typography
            variant="h6"
            noWrap
            component="a"
            href="/"
            sx={{
              mr: 2,
              display: { xs: 'none', md: 'flex' },
              fontFamily: 'monospace',
              fontWeight: 800,
              letterSpacing: '.1rem',
              color: 'inherit',
              textDecoration: 'none',
            }}
          >
            MilSOFTBurada
          </Typography>

          <Box sx={{ flexGrow: 1, display: { xs: 'flex', md: 'none' } }}>
            {/* <IconButton
              size="large"
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleOpenNavMenu}
              color="inherit"
            >
              <MenuIcon />
            </IconButton> */}
            <Menu
              id="menu-appbar"
              anchorEl={anchorElNav}
              anchorOrigin={{
                vertical: 'bottom',
                horizontal: 'left',
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'left',
              }}
              open={Boolean(anchorElNav)}
              onClose={handleCloseNavMenu}
              sx={{
                display: { xs: 'block', md: 'none' },
              }}
            >
              {pages.map((page) => (
                <MenuItem key={page} onClick={handleCloseNavMenu}>
                  <Typography textAlign="center">{page}</Typography>
                </MenuItem>
              ))}
            </Menu>
          </Box>
          {/* <AdbIcon sx={{ display: { xs: 'flex', md: 'none' }, mr: 1 }} /> */}
          <Typography
            variant="h5"
            noWrap
            component="a"
            href=""
            sx={{
              mr: 2,
              display: { xs: 'flex', md: 'none' },
              flexGrow: 1,
              fontFamily: 'monospace',
              fontWeight: 700,
              letterSpacing: '.1rem',
              color: 'inherit',
              textDecoration: 'none',
            }}
          >
            MilSOFTBurada
          </Typography>
          <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
            {pages.map((page) => (
              <Button
                key={page}
                onClick={handleCloseNavMenu}
                sx={{ my: 2, color: 'white', display: 'block' }}
              >
                {page}
              </Button>
            ))}
          </Box>

          <Box sx={{ flexGrow: 0 }}>
            {/* <div style={{display: "flex", flexDirection: "row", alignItems:"center"}}>
              <p style={{margin: 0, fontWeight: "bold", fontSize: "1.2rem"}}>Giriş Yap / Üye Ol</p>
              <PersonIcon style={{fontSize: "30"}}/>
            </div> */}
            <Button variant="text" style={{color: "white", textTransform: "none", height: "3rem"}} onClick={clickUserBtn}>
              <p style={{margin: 0, fontWeight: "bold", fontSize: "1.1rem"}}>Giriş Yap/Üye Ol</p>
              <PersonIcon style={{fontSize: "30"}}/>
            </Button>
          </Box>

          <Box sx={{ flexGrow: 0 }}>
          <Button variant="text" style={{color: "white", textTransform: "none", height: "3rem"}}>
            <IconButton aria-label="cart" onClick={clickCartBtn}>
              <StyledBadge badgeContent={basketCount} color="secondary" style={{color: "white", display: "flex", alignItems:"center"}}>
                <p style={{margin: 0, fontWeight: "bold", fontSize: "1.2rem"}}>Sepet</p>
                <ShoppingCartIcon style={{fontSize: "25"}}/>
              </StyledBadge>
            </IconButton>
            </Button>
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
export default Navbar;